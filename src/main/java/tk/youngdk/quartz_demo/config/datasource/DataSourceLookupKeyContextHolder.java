package tk.youngdk.quartz_demo.config.datasource;

public class DataSourceLookupKeyContextHolder {

    private static ThreadLocal<DataSourceType> dataSourceType = new ThreadLocal<>();

    public static void set(DataSourceType dataSourceType) {
        DataSourceLookupKeyContextHolder.dataSourceType.set(dataSourceType);
    }

    public static DataSourceType get() {
        return dataSourceType.get();
    }
}
