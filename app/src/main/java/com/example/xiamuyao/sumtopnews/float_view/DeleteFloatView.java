package com.example.xiamuyao.sumtopnews.float_view;

/**
 * created by tea9 at 2018/12/7
 */
//public class DeleteFloatView extends LinearLayout {
//
//    private ImageView mImageView;
//    private LinearLayout mLinearLayoutDeleteFloatView;
//    private TextView mTextViewDelete;
//    private WindowManager.LayoutParams mWindowManagerParams;
//
//    public DeleteFloatView(Context context) {
//        super(context);
//        initView();
//        initWindowManagerParams();
//    }
//
//    private void initView() {
//        LayoutInflater.from(getContext()).inflate(R.layout.delete_floatview, this);
//        this.mTextViewDelete = (TextView) findViewById(R.id.deletefloatview_textview_delete);
//        this.mImageView = (ImageView) findViewById(R.id.deletefloatview_imageview_delete);
//        this.mLinearLayoutDeleteFloatView = (LinearLayout) findViewById(R.id.deletefloatview_linearlayout);
////        setVisibility(8);
//    }
//
//    private void initWindowManagerParams() {
//        this.mWindowManagerParams = new WindowManager.LayoutParams();
//        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
//            this.mWindowManagerParams.type = 2002;
//        } else {
//            this.mWindowManagerParams.type = 2005;
//        }
//        this.mWindowManagerParams.format = 1;
//        this.mWindowManagerParams.flags = 40;
//        this.mWindowManagerParams.gravity = 8388659;
//        this.mWindowManagerParams.x = (AppDeviceUtils.getResolution(getContext()).x - this.mLinearLayoutDeleteFloatView.getLayoutParams().width) / 2;
//        this.mWindowManagerParams.y = AppDeviceUtils.getResolution(getContext()).y;
//        this.mWindowManagerParams.width = this.mLinearLayoutDeleteFloatView.getLayoutParams().width;
//        this.mWindowManagerParams.height = this.mLinearLayoutDeleteFloatView.getLayoutParams().height;
////        this.commonLog.m502e("小精灵宽>>>" + this.mWindowManagerParams.width);
////        this.commonLog.m502e("小精灵高>>>" + this.mWindowManagerParams.height);
//    }
//
//    public WindowManager.LayoutParams getLayoutParams() {
//        return this.mWindowManagerParams;
//    }
//
//    public int geTextViewtWidth() {
//        return this.mLinearLayoutDeleteFloatView.getLayoutParams().width;
//    }
//
//    public void setHide() {
//        this.mImageView.setImageResource(R.drawable.delete_floatview_in);
//        this.mTextViewDelete.setTextColor(getResources().getColor(R.color.green));
//    }
//
//    public void setNormal() {
//        this.mImageView.setImageResource(R.drawable.delete_floatview_out);
////        this.mTextViewDelete.setTextColor(getResources().getColor(17170443));
//    }
//
//    public void rotateScreen() {
////        this.commonLog.m502e(" mLinearLayoutDeleteFloatView.getLayoutParams().width>>" + this.mLinearLayoutDeleteFloatView.getLayoutParams().width);
//        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
//        this.mWindowManagerParams.x = (AppDeviceUtils.getResolution(getContext()).x - this.mLinearLayoutDeleteFloatView.getLayoutParams().width) / 2;
//        this.mWindowManagerParams.y = AppDeviceUtils.getResolution(getContext()).y;
//        windowManager.updateViewLayout(this, this.mWindowManagerParams);
//    }
//
//}
