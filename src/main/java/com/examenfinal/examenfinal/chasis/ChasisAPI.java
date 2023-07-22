package com.examenfinal.examenfinal.chasis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

@RestController
@RequestMapping("/api")
public class ChasisAPI {

    @GetMapping("/recursos")
    public String obtenerRecursos() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long start = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        int cpus = runtime.availableProcessors();
        long mmax = runtime.maxMemory() / 1024 / 1024;
        long mtotal = runtime.totalMemory() / 1024 / 1024;
        long mfree = runtime.freeMemory() / 1024 / 1024;
        File cDrive = new File("C:");
        double elapseTime = (System.nanoTime() - start) / 1_000_000_000;

        String response = "Datos de JVM\n";
        response += "CPUS: " + cpus + "\n";
        response += "Memoria Maxima: " + mmax + " MB\n";
        response += "Memoria total: " + mtotal + " MB\n";
        response += "Memoria Libre: " + mfree + " MB\n";
        response += "Tiempo sec: " + elapseTime + " segundos\n";
        response += String.format("Espacio total c: %.2f GB\n", (double) cDrive.getTotalSpace() / 1073741824);
        response += String.format("Espacio libre c: %.2f GB", (double) cDrive.getFreeSpace() / 1073741824);

        return response;
    }
}
