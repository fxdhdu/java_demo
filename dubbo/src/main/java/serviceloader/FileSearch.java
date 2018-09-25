package serviceloader;

import java.util.List;

/**
 * Created by fxd on 2018/9/26.
 */
public class FileSearch implements Search {

    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("FileSearch: " + keyword);
        return null;
    }
}
