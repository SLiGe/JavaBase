package com.java.thread_learn._wait.insert_example;

/**
 * @author Gary
 * @since 2019/12/04 15:28
 */
public class DBThreadMain {


    public static void main(String[] args) {
        DBTool dbTool = new DBTool();
        for (int i = 0; i < 10; i++) {
            new BackupAThread(dbTool).start();
            new BackupBThread(dbTool).start();
        }
    }


    static class BackupAThread extends Thread {

        private DBTool dbTool;

        public BackupAThread(DBTool dbTool) {
            super();
            this.dbTool = dbTool;
        }

        @Override
        public void run() {
            dbTool.backupA();
        }
    }

    static class BackupBThread extends Thread {

        private DBTool dbTool;

        public BackupBThread(DBTool dbTool) {
            super();
            this.dbTool = dbTool;
        }

        @Override
        public void run() {
            dbTool.backupB();
        }
    }

}
