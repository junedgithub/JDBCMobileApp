package MobileApp;

public class MobileDTO {
    private int modelNo;
    private String modelName;
    private String company;
    private int ram;
    private String camera;
    private double price;

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "modelNo=" + modelNo +
                ", modelName='" + modelName + '\'' +
                ", company='" + company + '\'' +
                ", ram=" + ram +
                ", camera='" + camera + '\'' +
                ", price=" + price;
    }
}
