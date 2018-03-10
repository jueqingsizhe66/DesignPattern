import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/*
iF folder file remove,modified,delete, folder create,modify,delete , all will be monitor
 */
public class TestFolder {
    public static void main(String[] args) {
        FileAlterationObserver fao = new FileAlterationObserver("D://aaa");
        fao.addListener(new FileAlterationListener() {
            @Override
            public void onStart(FileAlterationObserver fileAlterationObserver) {
                System.out.println("Start monitor^-^");
            }

            @Override
            public void onDirectoryCreate(File file) {
                System.out.println("Directory have been created"+ file);
            }

            @Override
            public void onDirectoryChange(File file) {
                System.out.println("Directory have been changed"+ file);

            }

            @Override
            public void onDirectoryDelete(File file) {
                System.out.println("Directory have been deleted"+ file);
            }

            @Override
            public void onFileCreate(File file) {
                System.out.println("File have been created"+ file);
            }

            @Override
            public void onFileChange(File file) {

                System.out.println("File have been changed"+ file);
            }

            @Override
            public void onFileDelete(File file) {

                System.out.println("File have been deleted"+ file);
            }

            @Override
            public void onStop(FileAlterationObserver fileAlterationObserver) {
                System.out.println("Stop monitor 88!");
            }
        });

        FileAlterationMonitor monitor = new FileAlterationMonitor(2000);
        monitor.addObserver(fao);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
