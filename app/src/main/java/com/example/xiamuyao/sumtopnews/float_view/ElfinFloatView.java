package com.example.xiamuyao.sumtopnews.float_view;

/**
 * created by tea9 at 2018/12/7
 */
//public class ElfinFloatView extends LinearLayout implements View.OnClickListener {
//
//    private static final int ELFIN_ORIENTATION_DOWN = 3;
//    private static final int ELFIN_ORIENTATION_LEFT = 4;
//    private static final int ELFIN_ORIENTATION_RIGHT = 2;
//    private static final int ELFIN_ORIENTATION_UP = 1;
//    private static final int LIMIT_ANGLE = 60;
//    private static final int LIMIT_COUNT = 2;
//    private static final int TIME_ADSORPTION = 2000;
//    private static final int TIME_INTERVAL = 1000;
//    private static final int TIME_TRANSLUCENT = 5000;
////    private CommonLog commonLog = new CommonLog();
//    private AppContext mAppContext;
//    private Context mContext;
//
//    private CountDownTimer mCountDownTimer = new CountDownTimer(7000, 1000) {
//        public void onTick(long millisUntilFinished) {
//            if (millisUntilFinished <= 3000 && millisUntilFinished > 2000) {
//                ElfinFloatView.this.mImageViewElfin.setAlpha(0.5f);
//                ElfinFloatView.this.changeToolBarState(false);
//            }
//        }
//
//        public void onFinish() {
//            int[] onScreenLocation = new int[2];
//            ElfinFloatView.this.mImageViewElfin.getLocationOnScreen(onScreenLocation);
//            if (((float) onScreenLocation[0]) >= (((float) AppDeviceUtils.getResolution(ElfinFloatView.this.getContext()).x) - ElfinFloatView.this.mDownX) / 2.0f) {
//                if (ElfinFloatView.this.mAppContext.STATE_SCRIPT == 2) {
//                    ElfinFloatView.this.mImageViewElfin.setImageResource(R.drawable.elfin_run_left_edge);
//                } else {
//                    ElfinFloatView.this.mImageViewElfin.setImageResource(R.drawable.elfin_normal_left_edge);
//                }
//            } else if (ElfinFloatView.this.mAppContext.STATE_SCRIPT == 2) {
//                ElfinFloatView.this.mImageViewElfin.setImageResource(R.drawable.elfin_run_right_edge);
//            } else {
//                ElfinFloatView.this.mImageViewElfin.setImageResource(R.drawable.elfin_normal_right_edge);
//            }
//        }
//    };
//    private DeleteFloatView mDeleteFloatView;
//    private float mDownX;
//    private float mDownY;
//    private ImageView mImageViewElfin;
//    public ImageView mImgRunAndStop;
//    private float mLastX;
//    private float mLastY;
//    private LinearLayout mLinearLayoutElfin;
//    private LinearLayout mLinearLayoutInfo;
//    private LinearLayout mLinearLayoutRun;
//    private LinearLayout mLinearLayoutSetting;
//    private LinearLayout mLinearLayoutTools;
//    private int mLockState;
//    private float mRawCurrentX;
//    private float mRawCurrentY;
//    private ScriptRTDDialog mScriptRTDDialog;
//    private ScriptUIDialog mScriptUIDialog;
//    public TextView mTvRunScript;
//    private WindowManager mWindowManager;
//    private LayoutParams mWindowManagerParams;
//    private OnHideCancelClickListener onHideCancelClickListener = new C09524();
//    private OnHideOKClickListener onHideOKClickListener = new C09513();
//    private final OnTouchListener onTouchListener = new C03432();
//
//    /* renamed from: com.cyjh.elfin.floatview.ElfinFloatView$2 */
//    class C03432 implements OnTouchListener {
//        private static final int MIN_MOVEMENT = 5;
//        private GestureDetector gestureDetector = new GestureDetector(ElfinFloatView.this.getContext(), this.gestureListener);
//        private ElfinGestureListener gestureListener = new ElfinGestureListener();
//
//        /* renamed from: com.cyjh.elfin.floatview.ElfinFloatView$2$1 */
//        class C03421 implements OnCancelListener {
//            C03421() {
//            }
//
//            public void onCancel(DialogInterface dialog) {
//                ElfinFloatView.this.moveToEdge();
//            }
//        }
//
//        C03432() {
//        }
//
//        public float getDistance(float x1, float y1, float x2, float y2) {
//            return (float) Math.sqrt(Math.pow((double) (x1 - x2), 2.0d) + Math.pow((double) (y1 - y2), 2.0d));
//        }
//
//        public boolean onTouch(View v, MotionEvent event) {
//            if (this.gestureDetector.onTouchEvent(event)) {
//                return true;
//            }
//            switch (event.getAction()) {
//                case 0:
//                    ElfinFloatView.this.resetElfinState();
//                    ElfinFloatView.this.mRawCurrentX = event.getRawX();
//                    ElfinFloatView.this.mRawCurrentY = event.getRawY() - ((float) AppDeviceUtils.getStatusBarHeight(ElfinFloatView.this.getContext()));
//                    ElfinFloatView.this.mDownX = event.getX();
//                    ElfinFloatView.this.mDownY = event.getY();
//                    break;
//                case 1:
//                    ElfinFloatView.this.mRawCurrentX = event.getRawX();
//                    ElfinFloatView.this.mRawCurrentY = event.getRawY() - ((float) AppDeviceUtils.getStatusBarHeight(ElfinFloatView.this.getContext()));
//                    if (!ElfinFloatView.this.isHide()) {
//                        if (ElfinFloatView.this.mLinearLayoutTools.getVisibility() == 8) {
//                            ElfinFloatView.this.moveToEdge();
//                        }
//                        ElfinFloatView.this.mDeleteFloatView.setVisibility(8);
//                        ElfinFloatView.this.mCountDownTimer.start();
//                        break;
//                    }
//                    HideFWDialog hideFWDialog = new HideFWDialog(ElfinFloatView.this.getContext());
//                    hideFWDialog.setOnHideOKClickListener(ElfinFloatView.this.onHideOKClickListener);
//                    hideFWDialog.setOnHideCancelClickListener(ElfinFloatView.this.onHideCancelClickListener);
//                    hideFWDialog.setOnCancelListener(new C03421());
//                    hideFWDialog.show();
//                    break;
//                case 2:
//                    if (ElfinFloatView.this.mLinearLayoutTools.getVisibility() == 0) {
//                        return true;
//                    }
//                    ElfinFloatView.this.mLastX = ElfinFloatView.this.mRawCurrentX;
//                    ElfinFloatView.this.mLastY = ElfinFloatView.this.mRawCurrentY;
//                    ElfinFloatView.this.mRawCurrentX = event.getRawX();
//                    ElfinFloatView.this.mRawCurrentY = event.getRawY() - ((float) AppDeviceUtils.getStatusBarHeight(ElfinFloatView.this.getContext()));
//                    if (getDistance(ElfinFloatView.this.mLastX, ElfinFloatView.this.mLastY, ElfinFloatView.this.mRawCurrentX, ElfinFloatView.this.mRawCurrentY) <= 5.0f) {
//                        return true;
//                    }
//                    int elfinDirection = 1;
//                    double degree = Math.toDegrees(Math.atan2((double) (ElfinFloatView.this.mRawCurrentY - ElfinFloatView.this.mLastY), (double) (ElfinFloatView.this.mRawCurrentX - ElfinFloatView.this.mLastX)));
//                    if (degree < -60.0d && degree > -120.0d) {
//                        elfinDirection = 1;
//                    } else if (degree >= -60.0d && degree <= 60.0d) {
//                        elfinDirection = 2;
//                    } else if (degree > 60.0d && degree < 120.0d) {
//                        elfinDirection = 3;
//                    } else if (degree >= 120.0d || degree <= -120.0d) {
//                        elfinDirection = 4;
//                    }
//                    ElfinFloatView.this.updateFloatViewDirection(elfinDirection);
//                    ElfinFloatView.this.updateFloatViewPosition((int) (ElfinFloatView.this.mRawCurrentX - ElfinFloatView.this.mDownX), (int) (ElfinFloatView.this.mRawCurrentY - ElfinFloatView.this.mDownY));
//                    if (ElfinFloatView.this.mDeleteFloatView.getVisibility() == 8) {
//                        ElfinFloatView.this.mDeleteFloatView.setVisibility(0);
//                    }
//                    if (ElfinFloatView.this.isHide()) {
//                        ElfinFloatView.this.mDeleteFloatView.setHide();
//                    } else {
//                        ElfinFloatView.this.mDeleteFloatView.setNormal();
//                    }
//                    return true;
//            }
//            return false;
//        }
//    }
//
//    private class ElfinGestureListener implements OnGestureListener {
//        private ElfinGestureListener() {
//        }
//
//        public boolean onDown(MotionEvent e) {
//            return false;
//        }
//
//        public void onShowPress(MotionEvent e) {
//        }
//
//        public boolean onSingleTapUp(MotionEvent e) {
//            if (ElfinFloatView.this.mDeleteFloatView.getVisibility() == 0) {
//                ElfinFloatView.this.mDeleteFloatView.setVisibility(8);
//            }
//            if (ElfinFloatView.this.mLinearLayoutTools.getVisibility() == 0) {
//                ElfinFloatView.this.changeToolBarState(false);
//            } else {
//                ElfinFloatView.this.changeToolBarState(true);
//            }
//            ElfinFloatView.this.mCountDownTimer.start();
//            return true;
//        }
//
//        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            return false;
//        }
//
//        public void onLongPress(MotionEvent e) {
//        }
//
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            return false;
//        }
//    }
//
//    /* renamed from: com.cyjh.elfin.floatview.ElfinFloatView$3 */
//    class C09513 implements OnHideOKClickListener {
//        C09513() {
//        }
//
//        public void onClick(View v) {
//            ElfinFloatView.this.toggleElfinVisbility();
//        }
//    }
//
//    /* renamed from: com.cyjh.elfin.floatview.ElfinFloatView$4 */
//    class C09524 implements OnHideCancelClickListener {
//        C09524() {
//        }
//
//        public void onClick(View v) {
//            ElfinFloatView.this.moveToEdge();
//        }
//    }
//
//    public ElfinFloatView(Context context, DeleteFloatView deleteFloatView) {
//        super(context);
//        this.mAppContext = (AppContext) context;
//        initView();
//        initWindow();
//        this.mDeleteFloatView = deleteFloatView;
//        this.mCountDownTimer.start();
//    }
//
//    private void initView() {
//        LayoutInflater.from(getContext()).inflate(R.layout.floatview_elfin, this);
//        this.mLinearLayoutElfin = (LinearLayout) findViewById(R.id.floatview_elfin_liearlayout_elfin);
//        this.mLinearLayoutTools = (LinearLayout) findViewById(R.id.floatview_elfin_liearlayout_tools);
//        this.mLinearLayoutRun = (LinearLayout) findViewById(R.id.floatview_linearlayout_run);
//        this.mLinearLayoutInfo = (LinearLayout) findViewById(R.id.floatview_linearlayout_info);
//        this.mLinearLayoutSetting = (LinearLayout) findViewById(R.id.floatview_linearlayout_setting);
//        this.mTvRunScript = (TextView) findViewById(R.id.id_tv_run_and_stop);
//        this.mImgRunAndStop = (ImageView) findViewById(R.id.floatview_imageview_run);
//        this.mLinearLayoutRun.setOnClickListener(this);
//        this.mLinearLayoutInfo.setOnClickListener(this);
//        this.mLinearLayoutSetting.setOnClickListener(this);
//        initElfinImageView();
//    }
//
//    private void initElfinImageView() {
//        this.mImageViewElfin = (ImageView) findViewById(R.id.floatview_elfin_imageview_elfin);
//        if (this.mAppContext.STATE_SCRIPT == 2) {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_run1);
//            this.mTvRunScript.setText(getContext().getString(R.string.floatview_elfin_stop));
//            this.mImgRunAndStop.setImageResource(R.drawable.floatview_elfin_stop);
//        } else {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_normal1);
//            this.mTvRunScript.setText(getContext().getString(R.string.floatview_elfin_run));
//            this.mImgRunAndStop.setImageResource(R.drawable.floatview_elfin_run);
//        }
//        this.mImageViewElfin.setOnClickListener(null);
//        this.mImageViewElfin.setOnTouchListener(this.onTouchListener);
//    }
//
//    private void initWindow() {
//        this.mWindowManager = (WindowManager) getContext().getSystemService("window");
//        this.mWindowManagerParams = new LayoutParams();
//        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 24) {
//            this.mWindowManagerParams.type = 2002;
//        } else {
//            this.mWindowManagerParams.type = 2005;
//        }
//        this.mWindowManagerParams.format = 1;
//        this.mWindowManagerParams.flags = 40;
//        this.mWindowManagerParams.gravity = 51;
//        this.mWindowManagerParams.x = AppDeviceUtils.getResolution(getContext()).x - this.mLinearLayoutElfin.getLayoutParams().width;
//        this.mWindowManagerParams.y = AppDeviceUtils.getResolution(getContext()).y / 4;
//        this.mRawCurrentY = (float) (AppDeviceUtils.getResolution(getContext()).y / 4);
//        this.mWindowManagerParams.width = this.mLinearLayoutElfin.getLayoutParams().width;
//        this.mWindowManagerParams.height = this.mLinearLayoutElfin.getLayoutParams().height;
//    }
//
//    public LayoutParams getLayoutParams() {
//        return this.mWindowManagerParams;
//    }
//
//    public void updateFloatViewPosition(int x, int y) {
//        this.mWindowManagerParams.x = x;
//        this.mWindowManagerParams.y = y;
//        this.mWindowManager.updateViewLayout(this, this.mWindowManagerParams);
//    }
//
//    private void moveToEdge() {
//        if (this.mDeleteFloatView.getVisibility() == 0) {
//            this.mDeleteFloatView.setVisibility(8);
//            this.mDeleteFloatView.setNormal();
//        }
//        int[] onScreenLocation = new int[2];
//        this.mImageViewElfin.getLocationOnScreen(onScreenLocation);
//        if (((float) onScreenLocation[0]) >= (((float) AppDeviceUtils.getResolution(getContext()).x) - this.mDownX) / 2.0f) {
//            updateFloatViewPosition(AppDeviceUtils.getResolution(getContext()).x, (int) (this.mRawCurrentY - this.mDownY));
//            this.mLinearLayoutElfin.removeView(this.mLinearLayoutTools);
//            this.mLinearLayoutElfin.addView(this.mLinearLayoutTools, 0);
//        } else {
//            updateFloatViewPosition(0, (int) (this.mRawCurrentY - this.mDownY));
//            this.mLinearLayoutElfin.removeView(this.mLinearLayoutTools);
//            this.mLinearLayoutElfin.addView(this.mLinearLayoutTools, 1);
//        }
//        if (this.mAppContext.STATE_SCRIPT == 2) {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_run1);
//        } else {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_normal1);
//        }
//    }
//
//    private void updateFloatViewDirection(int elfinDirection) {
//        switch (elfinDirection) {
//            case 1:
//                if (this.mAppContext.STATE_SCRIPT == 2) {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_run1);
//                    return;
//                } else {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_normal1);
//                    return;
//                }
//            case 2:
//                if (this.mAppContext.STATE_SCRIPT == 2) {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_run_right_up);
//                    return;
//                } else {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_normal_right_up);
//                    return;
//                }
//            case 3:
//                if (this.mAppContext.STATE_SCRIPT == 2) {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_run_down);
//                    return;
//                } else {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_normal_down);
//                    return;
//                }
//            case 4:
//                if (this.mAppContext.STATE_SCRIPT == 2) {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_run_left_up);
//                    return;
//                } else {
//                    this.mImageViewElfin.setImageResource(R.drawable.elfin_normal_left_up);
//                    return;
//                }
//            default:
//                return;
//        }
//    }
//
//    public void upadateElfinImages() {
//        if (this.mAppContext.STATE_SCRIPT == 2) {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_run1);
//        } else {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_normal1);
//        }
//        resetElfinState();
//        this.mCountDownTimer.start();
//    }
//
//    public void changeToolBarState(boolean isVisible) {
//        updateFloatViewDirection(1);
//        if (isVisible) {
//            if (this.mLinearLayoutTools.getVisibility() == 8) {
//                this.mLinearLayoutTools.setVisibility(0);
//            }
//        } else if (this.mLinearLayoutTools.getVisibility() == 0) {
//            this.mLinearLayoutTools.setVisibility(8);
//        }
//    }
//
//    private void resetElfinState() {
//        this.mCountDownTimer.cancel();
//        this.mImageViewElfin.setAlpha(1.0f);
//    }
//
//    private boolean isHide() {
//        int[] elfinOnScreenLocation = new int[2];
//        this.mImageViewElfin.getLocationOnScreen(elfinOnScreenLocation);
//        int[] deleteOnScreenLocation = new int[2];
//        this.mDeleteFloatView.getLocationOnScreen(deleteOnScreenLocation);
//        if (elfinOnScreenLocation[0] <= deleteOnScreenLocation[0] || elfinOnScreenLocation[0] >= deleteOnScreenLocation[0] + this.mDeleteFloatView.geTextViewtWidth() || elfinOnScreenLocation[1] <= deleteOnScreenLocation[1]) {
//            return false;
//        }
//        return true;
//    }
//
//    public void rotateScreen() {
//        resetElfinState();
//        this.mCountDownTimer.start();
//        updateFloatViewDirection(1);
//        this.mWindowManagerParams.x = AppDeviceUtils.getResolution(getContext()).x - this.mLinearLayoutElfin.getLayoutParams().width;
//        this.mWindowManagerParams.y = AppDeviceUtils.getResolution(getContext()).y / 4;
//        this.mWindowManager.updateViewLayout(this, this.mWindowManagerParams);
//        this.mDeleteFloatView.rotateScreen();
//    }
//
//    public void onClick(View v) {
//        resetElfinState();
//        switch (v.getId()) {
//            case R.id.floatview_linearlayout_run:
//                if (!MqRunner.getInstance().isScriptStarted()) {
//                    if (this.mAppContext.STATE_SCRIPT == 1) {
//                        this.mAppContext.runScript();
//                        break;
//                    }
//                }
//                MqRunner.getInstance().stop();
//                break;
//            break;
//            case R.id.floatview_linearlayout_info:
//                this.mScriptRTDDialog = new ScriptRTDDialog(getContext());
//                this.mScriptRTDDialog.show();
//                break;
//            case R.id.floatview_linearlayout_setting:
//                this.mScriptUIDialog = new ScriptUIDialog(getContext());
//                this.mScriptUIDialog.mContext = this.mContext;
//                this.mScriptUIDialog.show();
//                break;
//        }
//        this.mCountDownTimer.start();
//    }
//
//    public void toggleElfinVisbility() {
//        resetElfinState();
//        if (getVisibility() == 0) {
//            changeToolBarState(false);
//            this.mDeleteFloatView.setVisibility(8);
//            setVisibility(8);
//            return;
//        }
//        this.mCountDownTimer.start();
//        updateFloatViewPosition(AppDeviceUtils.getResolution(getContext()).x, AppDeviceUtils.getResolution(getContext()).y / 4);
//        setVisibility(0);
//    }
//
//    public void posContorlbar(float postion, int lockState) {
////        this.commonLog.m502e("postion>>>" + postion);
//        this.mLockState = lockState;
//        if (this.mLockState != 0) {
//            this.mImageViewElfin.setOnTouchListener(null);
//        }
//        if (this.mDeleteFloatView.getVisibility() == 0) {
//            this.mDeleteFloatView.setVisibility(8);
//            this.mDeleteFloatView.setNormal();
//        }
//        updateFloatViewPosition(AppDeviceUtils.getResolution(getContext()).x, (int) ((((float) AppDeviceUtils.getResolution(getContext()).y) * postion) - ((float) getHeight())));
//        this.mLinearLayoutElfin.removeView(this.mLinearLayoutTools);
//        this.mLinearLayoutElfin.addView(this.mLinearLayoutTools, 0);
//        if (this.mAppContext.STATE_SCRIPT == 2) {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_run1);
//        } else {
//            this.mImageViewElfin.setImageResource(R.drawable.elfin_normal1);
//        }
//    }
//
//    public Context getmContext() {
//        return this.mContext;
//    }
//
//    public void setmContext(Context mContext) {
//        this.mContext = mContext;
//    }
//
//    public void setImageViewElfinTouchListener() {
//        this.mImageViewElfin.setOnTouchListener(this.onTouchListener);
//    }
//
//
//}
