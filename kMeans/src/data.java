public class data {

    double latitude, longitude, brightness;
    int confidence, cluster;

    public data(double latitude, double longitude, double brightness, int confidence) {
        this.latitude = latitude;
        this.longitude = longitude;
        this. brightness = brightness;
        this.confidence = confidence;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getBrightness() {
        return this.brightness;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getCluster() {
        return this.cluster;
    }
}
