package services;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;


class RunTests {

    private static final Logger log = LoggerFactory.getLogger(RunTests.class);

    @Test
    void runTests() {

        //Test classpath
        Runner.Builder testBuilder = Runner.path("classpath:services");


        //Tags setup
//        testBuilder.tags("");

        String env = System.getProperty("karate.env");
        String tags = System.getProperty("karate.options");

        //Parallel setup
        String threadsProperty = System.getProperty("threads");
        int numberOfThreads = 1;

        if (threadsProperty != null) {
            try {
                numberOfThreads = Integer.parseInt(threadsProperty);
            } catch (NumberFormatException err) {
                log.warn(err.toString());
                log.warn("Fallback to single thread execution...");
            }
        }

        //Run tests
        Results results = testBuilder.parallel(numberOfThreads);
        generateReport(results.getReportDir());
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "automation-inm-api-karate");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}