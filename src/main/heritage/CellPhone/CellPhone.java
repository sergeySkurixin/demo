package heritage.CellPhone;


import heritage.Phone;

/**
 * Created by скурихин on 12.01.2017.
 */
public class CellPhone extends Phone{

    public CellPhone() {
    }

    @Override
    protected void method() {
        System.out.println("CellPhone");
        System.out.println(super.number);
    }

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.number="sdf";
        System.out.println(cellPhone.number);
        cellPhone.method();
    }
}
