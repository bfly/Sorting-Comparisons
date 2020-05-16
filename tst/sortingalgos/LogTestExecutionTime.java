package sortingalgos;

import org.junit.jupiter.api.extension.*;

public class LogTestExecutionTime implements BeforeTestExecutionCallback,
                                    AfterTestExecutionCallback {
private long startTime;

    @Override
    public void beforeTestExecution( ExtensionContext extensionContext ) throws Exception {
        startTime = System.currentTimeMillis();
    }
    @Override
    public void afterTestExecution( ExtensionContext extensionContext ) throws Exception {
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.printf("Test Execution took %d ms", elapsedTime);
    }

}
