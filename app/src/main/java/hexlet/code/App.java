package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)

class App implements Runnable {
/*
    @Parameters(index = "0", description = "name")
    boolean n;
*/
    @Option(names = {"-h", "--help"}, description = "Show this help message and exit.")
    private boolean help = true;
    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    private boolean version = true;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
        //System.exit();

    }
    @Override
    public void run() {
        System.out.println("Hello World222!");
        System.out.println(help);
        System.out.println(version);
    }
}
