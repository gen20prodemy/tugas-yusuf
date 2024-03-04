
#  Gen-20 Java Basic Structure

## Introduction

Project ini merupakan Tugas Basic Java dengan membuat project dengan nama **gen-20-java-basic-structure**

- Tugas yang pertama membuat Class yang didalamnya terdapat penggunaan atribut variabel
- Tugas Kedua membuat class perhitungan aritmatika sederhana
- Tugas ketiga membuat tampilan layar segitiga menggunakan looping
- Tugas keempat membuat method yang menampilkan hasil kategori bilangan (ganjil/genap) pada dua bilangan variabel yang dijumlahkan

Pada tugas ini saya menggunakan `Scanner` untuk memberikan interaksi kepada user agar dapat menentukan bilangan atau inputan pada terminal yang ingin dilakukan proses pada program.

## Class

Pada Pembuatan aplikasi ini akan dibuat beberapa class yang dimana saya membuat Class  **`Variabel`** untuk melakukan print beberapa tipe variabel, **`Arithmetics`** untuk melakukan perhitungan aritmatik sederhana, **`Triangle`** untuk melakukan print segitiga, dan **`OddEven`** untuk menentukan kategori bilangan hasil penjumlahan.

### Variabel

Di dalam Class Variabel berisikan beberapa variabel `a`, `b`, dan `c` yang memiliki tipe variabel yang berbeda - beda, variabel `a` memiliki tipe strings, variabel `b` memiliki tipe integer, dan variabel `c` memiliki tipe boolean. pada method yang ada pada Class Variabel ini akan melakukan print setiap variabel yang ada dan memberikan keterangan tipe variabel setiap variabel yang di print

### Arithmetics
Di dalam Class Arithmetics berisikan sebuah constructor *Arithmetics* untuk melakukan sebuah perhitungan aritmatika sederhana yaitu penjumlahan 2 buah variabel. untuk menggunakan class ini diharuskan memberikan inputan berupa variabel a dan b ketika memanggil class *Arithmetics*. Kemudian pengguna dapat memanggil method getResults untuk mengambil hasil dari operasi aritmatika sederhana.

### Triangle
Di dalam Class Triangle berisikan sebuah constructor *Triangle* yang berfungsi untuk melakukan Print out character **`*`** yang akan membentuk segitiga pada terminal berdasarkan jumlah baris yang dimasukkan. Untuk menggunakan Class ini pengguna diharuskan memberikan inputan berupa jumlah baris yang akan dilakukan print Triangle ketika melakukan inisialisasi object.

### OddEven
Di dalam Class OddEven berisikan sebuah method *Determine* yang berfungsi untuk melakukan sebuah pertambahan antara 2 buah variabel dan kemudian akan memberikan return berupa strings **ganjil** / **genap**. Untuk menggunakan method ini pengguna diharuskan memberikan inputan variabel a dan b untuk dilakukan penjumlahan dan penentuan kategori bilangan yang telah dijumlahkan.