package sk.fri.uniza.sporthealthsystem.module.statistics.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileHandler {

    public String readTextFile(String file) throws IOException {
        Path filePath = Paths.get("sqlStatistics").resolve(file + ".sql");

        BufferedReader br = Files.newBufferedReader(filePath);

        StringBuilder b = new StringBuilder();
        List<String> helper =  br.lines().collect(Collectors.toList());

        helper.forEach(i -> {
            b.append(i).append(" ");
        });

        return b.toString();
    }
}
