#!/bin/bash

TXT_FILE="failure-report.txt"

print_test_info() {
  if [[ -n "$name" ]]; then
    failure_message=$(echo "$failure_message" | sed 's/&lt;/</g; s/&gt;/>/g')
    info="\nTest Case: $name\nClass Name: $classname\nFailure Message: $failure_message\nFailure Type: $failure_type\n-----------------------------------"
    echo -e "$info"
  fi
}

name=""
classname=""
failure_message=""
failure_type=""
in_cdata=false
info=""

while IFS= read -r line; do
  if [[ $line =~ \<testcase ]]; then
    info+=$(print_test_info)

    name=$(echo "$line" | grep -oP 'name="\K[^"]+')
    classname=$(echo "$line" | grep -oP 'classname="\K[^"]+')
    failure_message=""
    failure_type=""
    in_cdata=false
  elif [[ $line =~ \<failure ]]; then
    failure_message=$(echo "$line" | grep -oP 'message="\K[^"]+')
    failure_type=$(echo "$line" | grep -oP 'type="\K[^"]+')
    in_cdata=true
  elif [[ $line =~ \]\]\> ]]; then
    in_cdata=false
    failure_cdata=$(echo "$line" | sed -n 's/.*\[CDATA\[\(.*\)\]\].*/\1/p')
    failure_message="${failure_message}${failure_cdata}"
  elif [[ $in_cdata == true ]]; then
    failure_cdata="${line}"
    failure_message="${failure_message}${failure_cdata}"
  elif [[ $line =~ \</testcase ]]; then
    info+=$(print_test_info)
    name=""
    classname=""
    failure_message=""
    failure_type=""
    failure_cdata=""
  fi
done < "$TXT_FILE"

info+=$(print_test_info)
echo "$info"
