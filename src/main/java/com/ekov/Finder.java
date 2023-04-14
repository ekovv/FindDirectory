package com.ekov;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


public class Finder {
    @Option(name = "-r")
    private boolean recursive;

    @Option(name = "-d", metaVar = "directory")
    private String directory;

    @Argument(required = true, metaVar = "nameFile")
    private String nameFile;


    private void parser(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        new Finder().doMain(args);
    }

    public String doMain(String[] args) {
        parser(args);
        System.out.println(find(getDirectory()));
        return find(getDirectory());
    }

    private String find(String dir) {
        File directory = new File(dir);
        File[] files = directory.listFiles();
        if (files == null) return null;
        for (File fileEntry : files) {
            if (fileEntry == null) continue;
            String path = Path.of(dir).resolve(fileEntry.getName()).toString();
            if (fileEntry.isDirectory() && getRecursive()) {
                String recursiveCall = find(path);
                if (Objects.nonNull(recursiveCall) && !recursiveCall.isEmpty()) return recursiveCall;
            }
            if (getNameFile().equals(fileEntry.getName())) return path;
        }
        return null;
    }


    public boolean getRecursive() {
        return recursive;
    }

    public String getDirectory() {
        return Objects.isNull(directory) ? Paths.get("").toAbsolutePath().toString() : directory;
    }

    public String getNameFile() {
        return nameFile;
    }
}