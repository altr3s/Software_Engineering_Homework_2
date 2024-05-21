package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class AppTest {
	public static List<BigInteger[]> readExpectations(String fileName) {
        List<BigInteger[]> expectations = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                BigInteger[] nums = new BigInteger[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    nums[i] = new BigInteger(parts[i]);
                }
                expectations.add(nums);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return expectations;
    }

    private void runTest(int index, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String[] nums = reader.readLine().split(" ");
            Assert.assertEquals(expectations.get(index)[0], App._min(nums));
            Assert.assertEquals(expectations.get(index)[1], App._max(nums));
            Assert.assertEquals(expectations.get(index)[2], App._sum(nums));
            Assert.assertEquals(expectations.get(index)[3], App._mult(nums));
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

	public String expectations_path = "src/test/resources/tests/expectations.txt";

    List<BigInteger[]> expectations = readExpectations(expectations_path);

    @Test
    public void test1() {
        runTest(0, "src/test/resources/tests/test_1.txt");
    }

    @Test
    public void test2() {
        runTest(1, "src/test/resources/tests/test_2.txt");
    }

    @Test
    public void test3() {
        runTest(2, "src/test/resources/tests/test_3.txt");
    }

    @Test
    public void test4() {
        runTest(3, "src/test/resources/tests/test_4.txt");
    }

    @Test
    public void test5() {
        runTest(4, "src/test/resources/tests/test_5.txt");
    }

    @Test
    public void test6() {
        runTest(5, "src/test/resources/tests/test_6.txt");
    }

    @Test
    public void test7() {
        runTest(6, "src/test/resources/tests/test_7.txt");
    }

    @Test
    public void test8() {
        runTest(7, "src/test/resources/tests/test_8.txt");
    }

    @Test
    public void test9() {
        runTest(8, "src/test/resources/tests/test_9.txt");
    }

    @Test
    public void test10() {
        runTest(9, "src/test/resources/tests/test_10.txt");
    }

    @Test
    public void test11() {
        runTest(10, "src/test/resources/tests/test_11.txt");
    }

    @Test
    public void test12() {
        runTest(11, "src/test/resources/tests/test_12.txt");
    }

    @Test
    public void test13() {
        runTest(12, "src/test/resources/tests/test_13.txt");
    }

    @Test
    public void test14() {
        runTest(13, "src/test/resources/tests/test_14.txt");
    }

    @Test
    public void test15() {
        runTest(14, "src/test/resources/tests/test_15.txt");
    }

    @Test
    public void test16() {
        runTest(15, "src/test/resources/tests/test_16.txt");
    }

    @Test
    public void test17() {
        runTest(16, "src/test/resources/tests/test_17.txt");
    }

    @Test
    public void test18() {
        runTest(17, "src/test/resources/tests/test_18.txt");
    }

    @Test
    public void test19() {
        runTest(18, "src/test/resources/tests/test_19.txt");
    }

    @Test
    public void test20() {
        runTest(19, "src/test/resources/tests/test_20.txt");
    }

    @Test
    public void test21() {
        runTest(20, "src/test/resources/tests/test_21.txt");
    }

    @Test
    public void test22() {
        runTest(21, "src/test/resources/tests/test_22.txt");
    }

    @Test
    public void test23() {
        runTest(22, "src/test/resources/tests/test_23.txt");
    }

    @Test
    public void test24() {
        runTest(23, "src/test/resources/tests/test_24.txt");
    }

    @Test
    public void test25() {
        runTest(24, "src/test/resources/tests/test_25.txt");
    }

    @Test
    public void test26() {
        runTest(25, "src/test/resources/tests/test_26.txt");
    }

    @Test
    public void test27() {
        runTest(26, "src/test/resources/tests/test_27.txt");
    }

    @Test
    public void test28() {
        runTest(27, "src/test/resources/tests/test_28.txt");
    }

    @Test
    public void test29() {
        runTest(28, "src/test/resources/tests/test_29.txt");
    }

    @Test
    public void test30() {
        runTest(29, "src/test/resources/tests/test_30.txt");
    }
	@Test
    public void test31() {
        runTest(30, "src/test/resources/tests/test_31.txt");
    }
}
