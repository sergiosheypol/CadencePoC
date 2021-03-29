import com.uber.cadence.worker.Worker;

public class Runner {
    public static void main(String[] args) {
        Worker.Factory factory = new Worker.Factory("test-domain");
        Worker worker = factory.newWorker("HelloWorldTaskList");
        worker.registerWorkflowImplementationTypes(PlainHelloWorld.class);
        factory.start();
    }
}
