package developerkampus.appcrud.model;

/**
 * Created by Wambakun on 12/05/2017.
 */

public class User {
    private String id,nama,username,password,alamat,notelp;

    public User(){

    }
    public User(String id,String nama,String password,String alamat,String notelp){
        this.id=id;
        this.nama=nama;
        this.password = password;
        this.alamat=alamat;
        this.notelp=notelp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}
