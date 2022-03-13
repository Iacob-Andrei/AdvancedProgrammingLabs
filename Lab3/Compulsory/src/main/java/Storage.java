public interface Storage {

    int getStorageCapacity();
    void setStorageCapacity(int storageCapacity);

    default double getStorageInMegabytes(int storageCapacity){
        return storageCapacity * 1024;
    }

    default double getStorageInKilobytes(int storageCapacity){
        return storageCapacity * 1024 * 1024;
    }

    default double getStorageInBytes(int storageCapacity){
        return storageCapacity * 1024 * 1024 * 1024;
    }
}
