package crud;

import pojo.DataSiswa;

public interface IFileCRUD {
    void addRow(DataSiswa data);
    void updateRow(DataSiswa data);
    void deleteRow(DataSiswa data);
}
