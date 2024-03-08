package interfacecrud;

import pojo.DataSiswa;

public interface ICRUD {
    void addElement(DataSiswa data);
    void deleteElement(DataSiswa data);
    void showElement();
    void updateElement(DataSiswa data);
}
