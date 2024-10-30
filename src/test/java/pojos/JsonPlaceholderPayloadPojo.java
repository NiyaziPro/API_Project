package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/*
Olusturdugumuz Pojo ile response'tan gelen data tam olarak uyumlu degilse ve response datasinda fazladan baska
fieldlar varsa bu field'lari gormezden gelmek icin Pojo classimizda
@JsonIgnoreProperties(ignoreUnknown = true) notasyonunu eklemeliyiz
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceholderPayloadPojo {

    /*
    POJO => Plain Old Java Object

    Pojo sinifinda olmasi gereken yapilar:
    1. Private Degiskenler :
        -JSON'da "key" olarak gorecegimiz her bir veri icin burada field olustururuz ve bunlari Private olarak tanimlariz.
        (dis erisimi sinirlandirmak icin)

    2. Parametreli ve Parametresiz Constructor:
        -Parametreli : Fieldlari baslangicta belirlemek icin
        -Parametresiz :

    3. Getter ve Setter Metodlari:
        -degiskenlere disaridan erisim vermek ve guncellemek icin

    4. toString() methodu :
        -nesneyi anlamli bir string formatinda goruntuleyebilmek icin

        !!! BU 4 YAPI, POJO CLASSTA OLMALIDIR !!!

     AMAC => Belli bir cerceveye bagli kalmadan, kendi data type'imizi olusturarak tasiyici objeler olusturmak!
     */

    private Integer userId;

    private String title;

    private Boolean completed;

    public JsonPlaceholderPayloadPojo() {
        //Serialization ve De-Serialization islemleri icin bu constructor'a ihtiyac duyariz
    }

    public JsonPlaceholderPayloadPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format("JsonPlaceholderPayloadPojo:%n" +
                        "userId     : %s%n" +
                        "title      : %s%n" +
                        "completed  : %s%n",
                userId, title, completed);
    }
}
