package com.aefyr.sai.installerx;

import androidx.annotation.Nullable;

import com.aefyr.sai.installerx.resolver.meta.Notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserContext {

    private Map<Category, SplitCategory> mIndex = new HashMap<>();
    private List<Notice> mNotices = new ArrayList<>();

    public ParserContext() {

    }

    @Nullable
    public SplitCategory getCategories(Category category) {
        return mIndex.get(category);
    }

    public SplitCategory getOrCreateCategory(Category category, String name, String description) {
        SplitCategory splitCategory = mIndex.get(category);
        if (splitCategory == null) {
            splitCategory = new SplitCategory(category, name, description);
            mIndex.put(category, splitCategory);
        }

        return splitCategory;
    }

    public List<SplitCategory> getCategoriesList() {
        return new ArrayList<>(mIndex.values());
    }

    public void addNotice(Notice notice) {
        mNotices.add(notice);
    }

    public List<Notice> getNotices() {
        return mNotices;
    }

}
