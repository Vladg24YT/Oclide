/*
 * The MIT License
 *
 * Copyright 2021 Vladislav Gorskii.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ru.VladTheMountain.oclide.util;

/**
 * Uses MightyPirates' original {@code UUID} library to generate component UUIDs
 *
 * @author VladTheMountain
 */
public class UUIDGenerator {

    /**
     *
     * @return the same result as OpenOS' {@code uuid.next()}
     */
    public static String create() {
        return li.cil.repack.org.luaj.vm2.lib.jse.JsePlatform.standardGlobals().load("local sets = {4, 2, 2, 2, 6}\n"
                + "  local result = \"\"\n"
                + "  local pos = 0\n"
                + "\n"
                + "  for _,set in ipairs(sets) do\n"
                + "    if result:len() > 0 then\n"
                + "      result = result .. \"-\"\n"
                + "    end\n"
                + "    for _ = 1,set do\n"
                + "      local byte = math.random(0, 255)\n"
                + "      if pos == 6 then\n"
                + "        byte = bit32.bor(bit32.band(byte, 0x0F), 0x40)\n"
                + "      elseif pos == 8 then\n"
                + "        byte = bit32.bor(bit32.band(byte, 0x3F), 0x80)\n"
                + "      end\n"
                + "      result = result .. string.format(\"%02x\", byte)\n"
                + "      pos = pos + 1\n"
                + "    end\n"
                + "  end\n"
                + "\n"
                + "  return result").call().tojstring();
    }
}
