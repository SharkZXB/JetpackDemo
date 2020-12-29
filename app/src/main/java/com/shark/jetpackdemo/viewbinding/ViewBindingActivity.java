package com.shark.jetpackdemo.viewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.shark.jetpackdemo.R;
import com.shark.jetpackdemo.databinding.ActivityViewBindingBinding;

/**
 * 视图绑定
 * <p>
 * 通过视图绑定功能，您可以更轻松地编写可与视图交互的代码。
 * 在模块中启用视图绑定之后，系统会为该模块中的每个 XML 布局文件生成一个绑定类。
 * 绑定类的实例包含对在相应布局中具有 ID 的所有视图的直接引用。
 * 在大多数情况下，视图绑定会替代 findViewById。
 * <p>
 * 注意：视图绑定在 Android Studio 3.6 Canary 11 及更高版本中可用。
 * <p>
 * 为某个模块启用视图绑定功能后，系统会为该模块中包含的每个 XML 布局文件生成一个绑定类。
 * 每个绑定类均包含对根视图以及具有 ID 的所有视图的引用。
 * 系统会通过以下方式生成绑定类的名称：将 XML 文件的名称转换为驼峰式大小写，并在末尾添加“Binding”一词。
 * 例如，假设某个布局文件的名称为 result_profile.xml：
 * <p>
 * <LinearLayout ... >
 * <TextView android:id="@+id/name" />
 * <ImageView android:cropToPadding="true" />
 * <Button android:id="@+id/button"
 * android:background="@drawable/rounded_button" />
 * </LinearLayout>
 * <p>
 * 所生成的绑定类的名称就为 ResultProfileBinding。此类具有两个字段：一个是名为 name 的 TextView，另一个是名为 button 的 Button。该布局中的 ImageView 没有 ID，因此绑定类中不存在对它的引用。
 * 每个绑定类还包含一个 getRoot() 方法，用于为相应布局文件的根视图提供直接引用。在此示例中，ResultProfileBinding 类中的 getRoot() 方法会返回 LinearLayout 根视图。
 * <p>
 * 在 Activity 中使用视图绑定
 * 如需设置绑定类的实例以供 Activity 使用，请在 Activity 的 onCreate() 方法中执行以下步骤：
 */
public class ViewBindingActivity extends AppCompatActivity {

    private ActivityViewBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用。
        // 通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
        // 将根视图传递到 setContentView()，使其成为屏幕上的活动视图。
        binding = ActivityViewBindingBinding.inflate(getLayoutInflater());
        ConstraintLayout view = binding.getRoot();
        setContentView(view);

        binding.btnWhoAmI.setOnClickListener(v -> {
            Toast.makeText(this, "我是谁", Toast.LENGTH_SHORT).show();
        });

        binding.btnWhereIAm.setOnClickListener(v -> {
            Toast.makeText(this, "我在哪里", Toast.LENGTH_SHORT).show();
        });

        // Fragment 填充
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.rl_contain, new ViewBindingFragment(), ViewBindingFragment.class.getName());
        ft.commit();

        // RecyclerView
        ViewBindingRVAdapter adapter = new ViewBindingRVAdapter();
        binding.rv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.rv.setLayoutManager(manager);

    }
}