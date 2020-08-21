package com.kjil.utils;

import com.kjil.domain.Participant;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Participant> parse(String path, String separator) throws IOException;
    List<Participant> parse(String path) throws IOException;
}
