package sample.Controller;

public abstract class AbstractController {
    private ModelAccess ma;

    public AbstractController(ModelAccess ma) {
        this.ma = ma;
    }

    public ModelAccess getModelAccess() {
        return ma;
    }
}
