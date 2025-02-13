package kcz;

import kcz.repository.utils.SQLiteExecutor;

public class Main {

    public static void main(String[] args) {
        SQLiteExecutor executor = new SQLiteExecutor();
        executor.resetDB();
        executor.printDatabase();
    }
}