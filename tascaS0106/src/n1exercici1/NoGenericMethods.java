package n1exercici1;

/**
 *Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes del 
 * mateix tipus, juntament amb els mètodes per a emmagatzemar i extreure 
 * aquests objectes i un constructor per a inicialitzar els tres.
 * Comprova que els arguments es poden posar en qualsevol posició
 * en la crida al constructor.
 * @author OCuevas
 */
public class NoGenericMethods<T> {

    private T obj1;
    private T obj2;
    private T obj3;

    public NoGenericMethods(T obj1, T obj2, T obj3) {
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public T getObj2() {
        return obj2;
    }

    public void setObj2(T obj2) {
        this.obj2 = obj2;
    }

    public T getObj3() {
        return obj3;
    }

    public void setObj3(T obj3) {
        this.obj3 = obj3;
    }

    @Override
    public String toString() {
        return "NoGenericMethods{" + "obj1=" + obj1 + ", obj2=" + obj2 + ", obj3=" + obj3 + '}';
    }
    
}