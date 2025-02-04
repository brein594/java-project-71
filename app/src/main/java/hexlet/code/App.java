package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

//import hexlet.code.Differ;


@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)
class  App implements Callable<String> {

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


    public static void main(String[] args) throws Exception {

        var exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);

    }


    @Override
    public String call() throws Exception {

        String result = "";
        try {
            result = Differ.generateYml(filepath1, filepath2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        return result;
    }


}
