package pars;

import pars.entities.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class Parser {
    public abstract List<Test> parse();

    protected List<String> getFileLines(String fileName) {
        Path path = null;
        try {
            path = Path.of(ClassLoader.getSystemResource(fileName).toURI());
        } catch (URISyntaxException e) {
            System.out.println("Invalid URI syntax for resource " + fileName);
            return null;
        }

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println(fileName + " not found");
        }

        return null;
    }
}
