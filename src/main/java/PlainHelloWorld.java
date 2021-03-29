import com.uber.cadence.workflow.Workflow;
import org.slf4j.Logger;

public class PlainHelloWorld implements HelloWorld {

    private final static Logger LOGGER = Workflow.getLogger(PlainHelloWorld.class);

    @Override
    public void sayHello(String name) {
        LOGGER.info("Hello " + name + " world!");
    }
}
