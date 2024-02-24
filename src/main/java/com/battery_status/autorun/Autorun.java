package com.battery_status.autorun;

import java.io.IOException;

public class Autorun {

	public void runBatteryStatus() {
		
		System.out.println("I am first action on start up the application :P");
		
	     // Ottieni la directory di lavoro corrente (dove si trova il JAR)
        String currentWorkingDirectory = System.getProperty("user.dir"); // get current path on run jar on windows or mac
		
		String os = System.getProperty("os.name").toLowerCase();

        try {
        	 if (os.contains("win")) {
                 // Sistema operativo Windows
                 System.out.println("Sistema operativo: Windows");
                 ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "powercfg /batteryreport /output \"" + currentWorkingDirectory + "\\battery-report.html\"");
                 processBuilder.start();
                 String filePath = currentWorkingDirectory + "\\battery-report.html";
                 Thread.sleep(750);
                 Runtime.getRuntime().exec("cmd /c start " + filePath);
             } else if (os.contains("nix") || os.contains("nux")) {
                 // Sistema operativo basato su Unix (Linux)
                 System.out.println("Sistema operativo: Unix (Linux)");
                 System.err.println("non prevista per macchine linux");
             }else if (os.contains("mac")) {
                 // Sistema operativo macOS
                 System.out.println("Sistema operativo: MacOS");
                 System.err.println("non prevista per macchine mac");
             } else {
                 // Altro sistema operativo non supportato
            	 System.err.println("Sistema operativo non supportato");
             }
        	 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
