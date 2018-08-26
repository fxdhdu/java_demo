package reflect;

/**
 * Created by fxd on 2018/8/26.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        /*sun.misc.Launcher$AppClassLoader@18b4aac2*/
        System.out.println("current loader:"+loader);

        /*sun.misc.Launcher$ExtClassLoader@73a28541*/
        System.out.println("parent loader:"+loader.getParent());

        /*null*/
        System.out.println("grandparent loader:"+loader.getParent().getParent());
    }
}
