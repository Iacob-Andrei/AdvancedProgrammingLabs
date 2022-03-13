package lab3.interfaces;

public interface Storage {

    int getStorageCapacity();
    void setStorageCapacity(int storageCapacity);

    /**
     * @param storageCapacity that need to be transformed
     * @return the storage given as argument computed in megabytes
     */
    default double getStorageInMegabytes(int storageCapacity){
        return storageCapacity * 1024;
    }

    /**
     * @param storageCapacity that need to be transformed
     * @return the storage given as argument computed in kilobytes
     */
    default double getStorageInKilobytes(int storageCapacity){
        return storageCapacity * 1024 * 1024;
    }

    /**
     * @param storageCapacity that need to be transformed
     * @return the storage given as argument computed in bytes
     */
    default double getStorageInBytes(int storageCapacity){
        return storageCapacity * 1024 * 1024 * 1024;
    }
}
