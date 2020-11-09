package tk.youngdk.quartz_demo.config.datasource;

public class DataSourceLookupKeyContextHolder {

    private static ThreadLocal<DataSourceType> dataSourceType = new ThreadLocal<>();
    private static ThreadLocal<DataSourceType> hotelDataSource = new ThreadLocal<>();
    private static final DataSourceType dowhatDataSource = DataSourceType.RAMADA;

    public static void set(DataSourceType dataSourceType) {
        DataSourceLookupKeyContextHolder.dataSourceType.set(dataSourceType);
    }

    public static DataSourceType get() {
        return dataSourceType.get();
    }

    public static void changeDowhat(){

        hotelDataSource.set(get());

        dataSourceType.set(dowhatDataSource);

    }

    public static void changeHotel(){

        dataSourceType.set(hotelDataSource.get());

    }

}
