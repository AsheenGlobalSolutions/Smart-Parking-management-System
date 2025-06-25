package lk.ijse.paymentservice.dto;

public class PaymentDTO {
    int paymentId;
    String plateNumber;
    String type;
    String brand;
    Long userId;
    boolean inside;

    public PaymentDTO(int paymentId, String plateNumber, String type, String brand, Long userId, boolean inside) {
        this.paymentId = paymentId;
        this.plateNumber = plateNumber;
        this.type = type;
        this.brand = brand;
        this.userId = userId;
        this.inside = inside;
    }

    public PaymentDTO() {
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isInside() {
        return inside;
    }

    public void setInside(boolean inside) {
        this.inside = inside;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId=" + paymentId +
                ", plateNumber='" + plateNumber + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", userId=" + userId +
                ", inside=" + inside +
                '}';
    }
}
