import com.uber.cadence.workflow.WorkflowMethod;

public interface HelloWorld {

    @WorkflowMethod
    void sayHello(String name);
}
