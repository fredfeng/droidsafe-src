package com.android.internal.view.menu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;

public class ActionMenuView extends LinearLayout implements MenuBuilder.ItemInvoker, MenuView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.021 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.021 -0400", hash_original_field = "0E213F9463B6EFE55ADA2109C5E5DC56", hash_generated_field = "3619C222EA285420CD3DE70ECE0D1D48")

    private boolean mReserveOverflow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.021 -0400", hash_original_field = "24BE2DD94A844242C35ABB990B9E3B93", hash_generated_field = "BC36FBD9CCAFE590BF9A0B51503C858E")

    private ActionMenuPresenter mPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.021 -0400", hash_original_field = "91949478145170F53463EA7B1D93DAAB", hash_generated_field = "6B2CAAF6AA38EAEFE2FA3F0FE80C1E20")

    private boolean mFormatItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.021 -0400", hash_original_field = "9EAE809C529287B9D5ACFCE152326FD4", hash_generated_field = "7ADECD8C88CFFA290657D73715D82527")

    private int mFormatItemsWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.022 -0400", hash_original_field = "C0CB7E511A75AFCB98C3B0342F6802E9", hash_generated_field = "303D27EFA1C100E376A8416C573EAB8F")

    private int mMinCellSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.022 -0400", hash_original_field = "25DB108BA28ED0013D5558630CEBAF2D", hash_generated_field = "32B1FF10CA48AFEEB7A5989848197D17")

    private int mGeneratedItemPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.022 -0400", hash_original_field = "B1E8AEB61B975F039E0DDB567198268F", hash_generated_field = "A7412B938C8635F667A20F8A5F45CA3A")

    private int mMeasuredExtraWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.022 -0400", hash_original_method = "AC153E2863979DC17A482AC64988B640", hash_generated_method = "5F3CB5A8A49E2CC16CAE28F7B3615920")
    public  ActionMenuView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.023 -0400", hash_original_method = "35E28BCF8B52367FF953A9B63C9F4F20", hash_generated_method = "066BBF3914A2E15DB33AB3EF69F2596D")
    public  ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setBaselineAligned(false);
        final float density = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int) (MIN_CELL_SIZE * density);
        mGeneratedItemPadding = (int) (GENERATED_ITEM_PADDING * density);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.023 -0400", hash_original_method = "F8B2E0B9AF6B77951E8DA779DE9E37B4", hash_generated_method = "2D2E0A69D628FF0C713DCBD58D8FEF6B")
    public void setPresenter(ActionMenuPresenter presenter) {
        mPresenter = presenter;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.023 -0400", hash_original_method = "309FFF524EE8C98ED8919EC0ED593079", hash_generated_method = "4DAACA12339968EF0454766F3050567B")
    public boolean isExpandedFormat() {
        boolean var91949478145170F53463EA7B1D93DAAB_1349607086 = (mFormatItems);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732979160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732979160;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.024 -0400", hash_original_method = "8C9F73227D09E5C25F24B8EE1F20BF37", hash_generated_method = "68A3A2D5FDA4B655E08FB19B4DD36A10")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        mPresenter.updateMenuView(false);
    if(mPresenter != null && mPresenter.isOverflowMenuShowing())        
        {
            mPresenter.hideOverflowMenu();
            mPresenter.showOverflowMenu();
        } 
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.025 -0400", hash_original_method = "7A0AC3F9A12B78835921801D3FB6DAA4", hash_generated_method = "6E2C6FE944B1E7FCF11828E57218B979")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        final boolean wasFormatted = mFormatItems;
        mFormatItems = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY;
    if(wasFormatted != mFormatItems)        
        {
            mFormatItemsWidth = 0;
        } 
        final int widthSize = MeasureSpec.getMode(widthMeasureSpec);
    if(mFormatItems && mMenu != null && widthSize != mFormatItemsWidth)        
        {
            mFormatItemsWidth = widthSize;
            mMenu.onItemsChanged(true);
        } 
    if(mFormatItems)        
        {
            onMeasureExactFormat(widthMeasureSpec, heightMeasureSpec);
        } 
        else
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } 
        
        
        
        
            
        
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.031 -0400", hash_original_method = "904CFC5C82A7517026F4582C82215F76", hash_generated_method = "351AAC975E15280A15A4812B651A8ADE")
    private void onMeasureExactFormat(int widthMeasureSpec, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        final int widthPadding = getPaddingLeft() + getPaddingRight();
        final int heightPadding = getPaddingTop() + getPaddingBottom();
        widthSize -= widthPadding;
        final int cellCount = widthSize / mMinCellSize;
        final int cellSizeRemaining = widthSize % mMinCellSize;
    if(cellCount == 0)        
        {
            setMeasuredDimension(widthSize, 0);
            return;
        } 
        final int cellSize = mMinCellSize + cellSizeRemaining / cellCount;
        int cellsRemaining = cellCount;
        int maxChildHeight = 0;
        int maxCellsUsed = 0;
        int expandableItemCount = 0;
        int visibleItemCount = 0;
        boolean hasOverflow = false;
        long smallestItemsAt = 0;
        final int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
        {
            final View child = getChildAt(i);
    if(child.getVisibility() == GONE)            
            continue;
            final boolean isGeneratedItem = child instanceof ActionMenuItemView;
            visibleItemCount++;
    if(isGeneratedItem)            
            {
                child.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
            } 
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
            lp.expanded = false;
            lp.extraPixels = 0;
            lp.cellsUsed = 0;
            lp.expandable = false;
            lp.leftMargin = 0;
            lp.rightMargin = 0;
            lp.preventEdgeOffset = isGeneratedItem && ((ActionMenuItemView) child).hasText();
            final int cellsAvailable = lp.isOverflowButton ? 1 : cellsRemaining;
            final int cellsUsed = measureChildForCells(child, cellSize, cellsAvailable,
                    heightMeasureSpec, heightPadding);
            maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
    if(lp.expandable)            
            expandableItemCount++;
    if(lp.isOverflowButton)            
            hasOverflow = true;
            cellsRemaining -= cellsUsed;
            maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
    if(cellsUsed == 1)            
            smallestItemsAt |= (1 << i);
        } 
        final boolean centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;
        boolean needsExpansion = false;
        while
(expandableItemCount > 0 && cellsRemaining > 0)        
        {
            int minCells = Integer.MAX_VALUE;
            long minCellsAt = 0;
            int minCellsItemCount = 0;
for(int i = 0;i < childCount;i++)
            {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
    if(!lp.expandable)                
                continue;
    if(lp.cellsUsed < minCells)                
                {
                    minCells = lp.cellsUsed;
                    minCellsAt = 1 << i;
                    minCellsItemCount = 1;
                } 
                else
    if(lp.cellsUsed == minCells)                
                {
                    minCellsAt |= 1 << i;
                    minCellsItemCount++;
                } 
            } 
            smallestItemsAt |= minCellsAt;
    if(minCellsItemCount > cellsRemaining)            
            break;
            minCells++;
for(int i = 0;i < childCount;i++)
            {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
    if((minCellsAt & (1 << i)) == 0)                
                {
    if(lp.cellsUsed == minCells)                    
                    smallestItemsAt |= 1 << i;
                    continue;
                } 
    if(centerSingleExpandedItem && lp.preventEdgeOffset && cellsRemaining == 1)                
                {
                    child.setPadding(mGeneratedItemPadding + cellSize, 0, mGeneratedItemPadding, 0);
                } 
                lp.cellsUsed++;
                lp.expanded = true;
                cellsRemaining--;
            } 
            needsExpansion = true;
        } 
        final boolean singleItem = !hasOverflow && visibleItemCount == 1;
    if(cellsRemaining > 0 && smallestItemsAt != 0 &&
                (cellsRemaining < visibleItemCount - 1 || singleItem || maxCellsUsed > 1))        
        {
            float expandCount = Long.bitCount(smallestItemsAt);
    if(!singleItem)            
            {
    if((smallestItemsAt & 1) != 0)                
                {
                    LayoutParams lp = (LayoutParams) getChildAt(0).getLayoutParams();
    if(!lp.preventEdgeOffset)                    
                    expandCount -= 0.5f;
                } 
    if((smallestItemsAt & (1 << (childCount - 1))) != 0)                
                {
                    LayoutParams lp = ((LayoutParams) getChildAt(childCount - 1).getLayoutParams());
    if(!lp.preventEdgeOffset)                    
                    expandCount -= 0.5f;
                } 
            } 
            final int extraPixels = expandCount > 0 ?
                    (int) (cellsRemaining * cellSize / expandCount) : 0;
for(int i = 0;i < childCount;i++)
            {
    if((smallestItemsAt & (1 << i)) == 0)                
                continue;
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
    if(child instanceof ActionMenuItemView)                
                {
                    lp.extraPixels = extraPixels;
                    lp.expanded = true;
    if(i == 0 && !lp.preventEdgeOffset)                    
                    {
                        lp.leftMargin = -extraPixels / 2;
                    } 
                    needsExpansion = true;
                } 
                else
    if(lp.isOverflowButton)                
                {
                    lp.extraPixels = extraPixels;
                    lp.expanded = true;
                    lp.rightMargin = -extraPixels / 2;
                    needsExpansion = true;
                } 
                else
                {
    if(i != 0)                    
                    {
                        lp.leftMargin = extraPixels / 2;
                    } 
    if(i != childCount - 1)                    
                    {
                        lp.rightMargin = extraPixels / 2;
                    } 
                } 
            } 
            cellsRemaining = 0;
        } 
    if(needsExpansion)        
        {
            int heightSpec = MeasureSpec.makeMeasureSpec(heightSize - heightPadding, heightMode);
for(int i = 0;i < childCount;i++)
            {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
    if(!lp.expanded)                
                continue;
                final int width = lp.cellsUsed * cellSize + lp.extraPixels;
                child.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), heightSpec);
            } 
        } 
    if(heightMode != MeasureSpec.EXACTLY)        
        {
            heightSize = maxChildHeight;
        } 
        setMeasuredDimension(widthSize, heightSize);
        mMeasuredExtraWidth = cellsRemaining * cellSize;
        
        
    }

    
        static int measureChildForCells(View child, int cellSize, int cellsRemaining,
            int parentHeightMeasureSpec, int parentHeightPadding) {
        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
        final int childHeightSize = MeasureSpec.getSize(parentHeightMeasureSpec) -
                parentHeightPadding;
        final int childHeightMode = MeasureSpec.getMode(parentHeightMeasureSpec);
        final int childHeightSpec = MeasureSpec.makeMeasureSpec(childHeightSize, childHeightMode);
        int cellsUsed = 0;
        if (cellsRemaining > 0) {
            final int childWidthSpec = MeasureSpec.makeMeasureSpec(
                    cellSize * cellsRemaining, MeasureSpec.AT_MOST);
            child.measure(childWidthSpec, childHeightSpec);
            final int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) cellsUsed++;
        }
        final ActionMenuItemView itemView = child instanceof ActionMenuItemView ?
                (ActionMenuItemView) child : null;
        final boolean expandable = !lp.isOverflowButton && itemView != null && itemView.hasText();
        lp.expandable = expandable;
        lp.cellsUsed = cellsUsed;
        final int targetWidth = cellsUsed * cellSize;
        child.measure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                childHeightSpec);
        return cellsUsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.037 -0400", hash_original_method = "CF95DF9C40DBA0243EC42554D6345F0F", hash_generated_method = "A0AE65CF768F5E9575C7669F802D5C80")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
    if(!mFormatItems)        
        {
            super.onLayout(changed, left, top, right, bottom);
            return;
        } 
        final int childCount = getChildCount();
        final int midVertical = (top + bottom) / 2;
        final int dividerWidth = getDividerWidth();
        int overflowWidth = 0;
        int nonOverflowWidth = 0;
        int nonOverflowCount = 0;
        int widthRemaining = right - left - getPaddingRight() - getPaddingLeft();
        boolean hasOverflow = false;
for(int i = 0;i < childCount;i++)
        {
            final View v = getChildAt(i);
    if(v.getVisibility() == GONE)            
            {
                continue;
            } 
            LayoutParams p = (LayoutParams) v.getLayoutParams();
    if(p.isOverflowButton)            
            {
                overflowWidth = v.getMeasuredWidth();
    if(hasDividerBeforeChildAt(i))                
                {
                    overflowWidth += dividerWidth;
                } 
                int height = v.getMeasuredHeight();
                int r = getWidth() - getPaddingRight() - p.rightMargin;
                int l = r - overflowWidth;
                int t = midVertical - (height / 2);
                int b = t + height;
                v.layout(l, t, r, b);
                widthRemaining -= overflowWidth;
                hasOverflow = true;
            } 
            else
            {
                final int size = v.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                nonOverflowWidth += size;
                widthRemaining -= size;
    if(hasDividerBeforeChildAt(i))                
                {
                    nonOverflowWidth += dividerWidth;
                } 
                nonOverflowCount++;
            } 
        } 
    if(childCount == 1 && !hasOverflow)        
        {
            final View v = getChildAt(0);
            final int width = v.getMeasuredWidth();
            final int height = v.getMeasuredHeight();
            final int midHorizontal = (right - left) / 2;
            final int l = midHorizontal - width / 2;
            final int t = midVertical - height / 2;
            v.layout(l, t, l + width, t + height);
            return;
        } 
        final int spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);
        final int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
        int startLeft = getPaddingLeft();
for(int i = 0;i < childCount;i++)
        {
            final View v = getChildAt(i);
            final LayoutParams lp = (LayoutParams) v.getLayoutParams();
    if(v.getVisibility() == GONE || lp.isOverflowButton)            
            {
                continue;
            } 
            startLeft += lp.leftMargin;
            int width = v.getMeasuredWidth();
            int height = v.getMeasuredHeight();
            int t = midVertical - height / 2;
            v.layout(startLeft, t, startLeft + width, t + height);
            startLeft += width + lp.rightMargin + spacerSize;
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.038 -0400", hash_original_method = "BCFF92F724E40A93547AD27810B374B7", hash_generated_method = "20B039D9957A5ED6936C442629CD13D4")
    @Override
    public void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.038 -0400", hash_original_method = "9F44211E52A7149BFED02520B6DEF800", hash_generated_method = "4A541722BAB683D3F8F9CC4C1F18340E")
    public boolean isOverflowReserved() {
        boolean var0E213F9463B6EFE55ADA2109C5E5DC56_1992868213 = (mReserveOverflow);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245485852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245485852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.039 -0400", hash_original_method = "F5103BD0EA93D884CF8413DB778005C1", hash_generated_method = "15B323109E8BF25E66710A01C5BEDE02")
    public void setOverflowReserved(boolean reserveOverflow) {
        mReserveOverflow = reserveOverflow;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.039 -0400", hash_original_method = "DEBB4048965D8045F192555AB279F2BA", hash_generated_method = "AC6BB9D76D2863176B248964BAEE99A5")
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
LayoutParams varD15CEB6F45B18F7EB233792D020C6115_1792298670 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_1792298670.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_1792298670;
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.040 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "9798211EADEDDCA9FF4E48CE48DE5706")
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams var023B3FAAA9940C6DE114BF4C9FED2D73_2094023663 =         new LayoutParams(getContext(), attrs);
        var023B3FAAA9940C6DE114BF4C9FED2D73_2094023663.addTaint(taint);
        return var023B3FAAA9940C6DE114BF4C9FED2D73_2094023663;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.040 -0400", hash_original_method = "6543FCE3043AA8E09E4AB46D137D1290", hash_generated_method = "A084CAC4D043FAD1C71A71C1496CAE7C")
    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
    if(p instanceof LayoutParams)        
        {
            LayoutParams result = new LayoutParams((LayoutParams) p);
    if(result.gravity <= Gravity.NO_GRAVITY)            
            {
                result.gravity = Gravity.CENTER_VERTICAL;
            } 
LayoutParams varDC838461EE2FA0CA4C9BBB70A15456B0_1603846395 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1603846395.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1603846395;
        } 
LayoutParams var0E81305CCB52037DAA521CD210230A11_405161328 =         generateDefaultLayoutParams();
        var0E81305CCB52037DAA521CD210230A11_405161328.addTaint(taint);
        return var0E81305CCB52037DAA521CD210230A11_405161328;
        
        
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.041 -0400", hash_original_method = "C7A39F9D75FC22971A40D0A54E61424A", hash_generated_method = "6F186FAF802BF712258A322803C35EAD")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean varD4BC6F36F8FF9315DFC5A9C362F031CB_230555077 = (p != null && p instanceof LayoutParams);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951508791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951508791;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.041 -0400", hash_original_method = "AF673847AD60845228ED5C7DBF294789", hash_generated_method = "F0A5FAFAC28638179B5CE74517192E42")
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams result = generateDefaultLayoutParams();
        result.isOverflowButton = true;
LayoutParams varDC838461EE2FA0CA4C9BBB70A15456B0_1821093220 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1821093220.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1821093220;
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.041 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "D64113141E3C2DEF104FC30AA897240E")
    public boolean invokeItem(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var9CE0C397DB4ABF248543C034E9F3CC19_300096627 = (mMenu.performItemAction(item, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_38075050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_38075050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.041 -0400", hash_original_method = "DC1BDB1B98459EBD06B93B75A5D0D038", hash_generated_method = "0B305C2971E98375BC871586DF29AF88")
    public int getWindowAnimations() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2123009705 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450433540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450433540;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.042 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "E50EB2D0FDCBBA00CCFEFF4A83375DDF")
    public void initialize(MenuBuilder menu) {
        mMenu = menu;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.042 -0400", hash_original_method = "9B32BE6DC23F13B511A55013BB42C488", hash_generated_method = "D4EE5C7BB50C682E643CFA5A66A5B483")
    @Override
    protected boolean hasDividerBeforeChildAt(int childIndex) {
        addTaint(childIndex);
        final View childBefore = getChildAt(childIndex - 1);
        final View child = getChildAt(childIndex);
        boolean result = false;
    if(childIndex < getChildCount() && childBefore instanceof ActionMenuChildView)        
        {
            result |= ((ActionMenuChildView) childBefore).needsDividerAfter();
        } 
    if(childIndex > 0 && child instanceof ActionMenuChildView)        
        {
            result |= ((ActionMenuChildView) child).needsDividerBefore();
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_1148624026 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925642858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_925642858;
        
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_method = "87E5D39D1D82C11AB077A37A8786E27E", hash_generated_method = "13653DC0ECECEAC82CDEBC5217F29C58")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_801836289 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619446743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619446743;
        
        
    }

    
    public static class LayoutParams extends LinearLayout.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_field = "BC891BAF62FC8DDB492AD764B3ECB81D", hash_generated_field = "06AA5094630821EA9900D65F21750F66")

        @ViewDebug.ExportedProperty(category = "layout") public boolean isOverflowButton;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_field = "E7EEEFE3F1DABDA5F3DF051861EACC10", hash_generated_field = "E1D8EB1EB816463205B2DDDF77A75406")

        @ViewDebug.ExportedProperty(category = "layout") public int cellsUsed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_field = "676598AABCF21B3A19E3058EF2F83A07", hash_generated_field = "C29D7D4D121FC646F2A1DA13C25BE452")

        @ViewDebug.ExportedProperty(category = "layout") public int extraPixels;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_field = "34ADC2548F6C20BFDE9DEF65C39FC4CD", hash_generated_field = "3C4066DDF8E8E17F2EF63131655754FD")

        @ViewDebug.ExportedProperty(category = "layout") public boolean expandable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_field = "13DDB03DB32CFB3CB44D09E16E3A67C5", hash_generated_field = "E66E784ED3625370EFD8B17A60737371")

        @ViewDebug.ExportedProperty(category = "layout") public boolean preventEdgeOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_field = "1A6130A21D7D578D81A168EBCF0D9921", hash_generated_field = "A93A7FF052663F567D43ED21528A4163")

        public boolean expanded;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.043 -0400", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "7441F800C0B184928DB48A9DD8178D32")
        public  LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.044 -0400", hash_original_method = "1AEEB2B6AE567062F04CDAB99E43CD26", hash_generated_method = "5F38F7306F4BCF2F00B15945AC196DD5")
        public  LayoutParams(LayoutParams other) {
            super((LinearLayout.LayoutParams) other);
            isOverflowButton = other.isOverflowButton;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.044 -0400", hash_original_method = "5CB9C8D742F9EAB0281FCB85ADC86E3D", hash_generated_method = "2D975EB34A3ADA57F52E23D931609107")
        public  LayoutParams(int width, int height) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            isOverflowButton = false;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.044 -0400", hash_original_method = "0D80B5BE9184580A03D083B0A94309F3", hash_generated_method = "D0D8E0AD3CFB289080395CFE0BEFE1E5")
        public  LayoutParams(int width, int height, boolean isOverflowButton) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            this.isOverflowButton = isOverflowButton;
            
            
        }

        
    }


    
    public interface ActionMenuChildView {
        public boolean needsDividerBefore();
        public boolean needsDividerAfter();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.044 -0400", hash_original_field = "B9C30FC7E4A7160F4B35C4CEFD8C059C", hash_generated_field = "1CEFC30E74C2ED26E1D7A5895C1A6938")

    private static final String TAG = "ActionMenuView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.045 -0400", hash_original_field = "31E1444ACC597D97F7D1F308819AC54B", hash_generated_field = "C82EA13B7AFB56A9509B0706C650CC26")

    static final int MIN_CELL_SIZE = 56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:31.045 -0400", hash_original_field = "2BD151CF00588194F99C1F7C0113FF34", hash_generated_field = "7918CEA6EF4CC9E7E97331DC428C97AE")

    static final int GENERATED_ITEM_PADDING = 4;
}

