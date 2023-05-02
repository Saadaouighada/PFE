package com.linedata.project.management.std.services.entity.adaptor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.linedata.project.management.std.services.entity.Tags;
import com.linedata.project.management.std.services.entity.impl.TagsImpl;

public class TagsAdaptor extends XmlAdapter<TagsImpl, Tags> {
	@Override
	public Tags unmarshal(TagsImpl v) throws Exception {
		if (v instanceof TagsImpl) {
			return (TagsImpl) v;
		}
		return null;
	}

	@Override
	public TagsImpl marshal(Tags v) throws Exception {
		return (TagsImpl) v;
	}

}
