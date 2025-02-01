package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)

class App implements Runnable {

    @Parameters(index = "0", description = "path to first file")
    String filepath1;
    @Parameters(index = "1", description = "path to second file")
    String filepath2;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean help = true;
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean version = true;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format = "stylish";


    private static Path readFixture(String filepath) throws Exception {
        return Paths.get(filepath);
    }

    private static String readFile(Path filepath) throws Exception {
        return Files.readString(filepath).trim();
    }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
        //System.exit();

    }

    @Override
    public void run() {
        System.out.println("Hello World!");
        System.out.println(help);
        System.out.println(version);
        System.out.println(format);
    }
}
