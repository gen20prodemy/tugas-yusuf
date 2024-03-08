package interfacecrud;

import pojo.DataSiswa;

public abstract class CRUD {
    public abstract void addElement(DataSiswa data);
    public abstract void deleteElement(DataSiswa data);
    public abstract void showElement();
    public abstract void updateElement(DataSiswa data);
}
