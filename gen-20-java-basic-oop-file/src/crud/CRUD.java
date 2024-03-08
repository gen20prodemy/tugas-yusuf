package crud;

import pojo.DataSiswa;

public abstract class CRUD {
    public abstract void addRow(DataSiswa data);
    public abstract void updateRow(DataSiswa data);
    public abstract void deleteRow(DataSiswa data);
}
