package ingestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeaderFooterSplitter {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Split Header and Footer
        splitHeaderFooter("sample.txt", processBuilder);
        System.out.println();
        // Fetch Record Count
        fetchRecordCount("sample.txt", processBuilder);
        System.out.println();
        // Create File Without Header and Footer
        withoutHeaderFooter("sample.txt", processBuilder);
        System.out.println();
    }

    private static void splitHeaderFooter(String fileName, ProcessBuilder processBuilder) throws IOException, InterruptedException {
        StringBuilder command = new StringBuilder();
        command.append("sed -n '1p;$p' ").append(fileName).append(" > ").append("header_footer.txt");
        System.out.println(response(fileName, processBuilder, command.toString()));
    }

    private static void fetchRecordCount(String fileName, ProcessBuilder processBuilder) throws IOException, InterruptedException {
        StringBuilder command = new StringBuilder();
        command.append("awk 'END{print NR-2}' ").append(fileName).append(" > ").append("record_count.txt");
        System.out.println(response(fileName, processBuilder, command.toString()));
    }

    private static void withoutHeaderFooter(String fileName, ProcessBuilder processBuilder) throws IOException, InterruptedException {
        StringBuilder command = new StringBuilder();
        command.append("sed '1d; $d' ").append(fileName).append(" > ").append("without_header_footer.txt");
        System.out.println(response(fileName, processBuilder, command.toString()));
    }

    private static String response(String fileName, ProcessBuilder processBuilder, String command) throws IOException, InterruptedException {
        StringBuilder errorMessage = new StringBuilder();
        Process process = processBuilder.command("bash", "-c", command).start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                errorMessage.append(line).append(", ");
            }
        }
        int exitValue = process.waitFor();
        StringBuilder response = new StringBuilder();
        response.append("fileName: ").append(fileName).append(", command: ").append(command).append(", exitValue: ").append(exitValue);
        if (exitValue == 0) {
            response.append(", status: ").append("PASS");
        } else {
            response.append(", status: ").append("FAIL").append(", errorMessage: ").append(errorMessage);
        }
        return response.toString();
    }
}
