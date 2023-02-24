package ru.netology.StatisticOfSales.services;

public class StatsService {

    public int getSalesQuantity(long[] sales) {
        int salesQuantity = 0;
        for (int i = 0; i < sales.length; i++) {
            salesQuantity = (int) (salesQuantity + sales[i]);
        }
        return salesQuantity;
    }

    public int getAverageMontlySales(long[] sales) {
        int AverageMonthlySales = getSalesQuantity(sales) / sales.length;
        return AverageMonthlySales;
    }

    public int getMaxMonth(long[] sales) {
        int maxMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) {
                maxMonth = i;
            }
        }
        return maxMonth + 1;
    }


    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }
    /*далее реализация метода вычисления месяца с минимальными продажами
    //несколько другим путём:
    public int getMinMonth(long[] sales) {
        int minMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) {
                minMonth = i;
            }
        }
        return minMonth + 1;
    }*/

    public int getMonthWithSalesUnderAverage(long[] sales) {
        int monthUnderAverage = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] < getAverageMontlySales(sales))
                monthUnderAverage = monthUnderAverage + 1;
        }
        return monthUnderAverage;
    }

    public int getMonthWithSalesOverAverage(long[] sales) {
        int monthOverAverage = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > getAverageMontlySales(sales))
                monthOverAverage = monthOverAverage + 1;
        }
        return monthOverAverage;
    }

}
