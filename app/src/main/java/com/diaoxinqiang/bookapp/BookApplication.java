package com.diaoxinqiang.bookapp;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by Administrator on 2015/12/14.
 */
public class BookApplication extends Application {


    @Override
    public void onCreate() {
        // TODO 自动生成的方法存根
        super.onCreate();
        //通过配置方案来初始化ImageLoader
        ImageLoader.getInstance().init(getWholeConfig());
    }

    /**
     * 创建默认的ImageLoader配置参数，这里创建了一个默认的配置方案
     *
     * @return
     */
    private ImageLoaderConfiguration getDefaultConfig() {
        ImageLoaderConfiguration config = ImageLoaderConfiguration
                .createDefault(getApplicationContext());
        return config;
    }

    /**
     * 所有的配置参数举例
     *
     * @return
     */
    private ImageLoaderConfiguration getWholeConfig() {
        //设置默认的配置，设置缓存，这里不设置可以到别的地方设置
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        //设置缓存的路径
        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");

        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .memoryCacheExtraOptions(50, 100) //即保存的每个缓存文件的最大长宽
                .threadPoolSize(3) //线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                        //解释：当同一个Uri获取不同大小的图片，缓存到内存时，只缓存一个。默认会缓存多个不同的大小的相同图片
                .denyCacheImageMultipleSizesInMemory()  //拒绝缓存多个图片。
                .memoryCache(new WeakMemoryCache()) //缓存策略你可以通过自己的内存缓存实现 ，这里用弱引用，缺点是太容易被回收了，不是很好！
                .memoryCacheSize(2 * 1024 * 1024) //设置内存缓存的大小
                .diskCacheSize(50 * 1024 * 1024) //设置磁盘缓存大小 50M
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO) //设置图片下载和显示的工作队列排序
                .diskCacheFileCount(100) //缓存的文件数量
                .diskCache(new UnlimitedDiskCache(cacheDir)) //自定义缓存路径
                .defaultDisplayImageOptions(defaultOptions) //显示图片的参数，默认：DisplayImageOptions.createSimple()
                .imageDownloader(new BaseImageDownloader(getApplicationContext(), 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() //打开调试日志
                .build();//开始构建
        return config;
    }

    /**
     * 比较常用的配置方案
     *
     * @return
     */
    private ImageLoaderConfiguration getSimpleConfig() {
        //设置缓存的路径
        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");

        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .memoryCacheExtraOptions(50, 100) //即保存的每个缓存文件的最大长宽
                .threadPriority(Thread.NORM_PRIORITY - 2) //线程池中线程的个数
                .denyCacheImageMultipleSizesInMemory() //禁止缓存多张图片
                .memoryCache(new LRULimitedMemoryCache(50 * 1024 * 1024)) //缓存策略
                .memoryCacheSize(50 * 1024 * 1024) //设置内存缓存的大小
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //缓存文件名的保存方式
                .diskCacheSize(200 * 1024 * 1024) //磁盘缓存大小
                .tasksProcessingOrder(QueueProcessingType.LIFO) //工作队列
                .diskCacheFileCount(200) //缓存的文件数量
                .diskCache(new UnlimitedDiskCache(cacheDir)) //自定义缓存路径
                        //.writeDebugLogs() // Remove for release app
                .build();
        return config;
    }




/*    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
    .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
    .diskCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
    .taskExecutor(...)
    .taskExecutorForCachedImages(...)
    .threadPoolSize(3) // default
    .threadPriority(Thread.NORM_PRIORITY - 1) // default
    .tasksProcessingOrder(QueueProcessingType.FIFO) // default
    .denyCacheImageMultipleSizesInMemory()
    .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
    .memoryCacheSize(2 * 1024 * 1024)
    .memoryCacheSizePercentage(13) // default
    .diskCache(new UnlimitedDiscCache(cacheDir)) // default
    .diskCacheSize(50 * 1024 * 1024)
    .diskCacheFileCount(100)
    .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
    .imageDownloader(new BaseImageDownloader(context)) // default
    .imageDecoder(new BaseImageDecoder()) // default
    .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
    .writeDebugLogs()
    .build();  */
}