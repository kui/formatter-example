package kui.javaformatter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

public class JavaFormatter {
    private CodeFormatter formatter;

    public JavaFormatter() {
        formatter = ToolFactory.createCodeFormatter(null);
    }

    /**
     * hogehoge
     * fugafuga
     */
    public String format(File file, Charset charset) throws IOException, MalformedTreeException, BadLocationException {
        String contents = new String(Files.readAllBytes(file.toPath()), charset);
        TextEdit edit = formatter.format(CodeFormatter.K_COMPILATION_UNIT, contents, 0, contents.length(), 0, null);
        IDocument doc = new Document();
        doc.set(contents);
        edit.apply(doc);
        return doc.get();
    }

    public static void main(String[] args) throws Exception {
        JavaFormatter f = new JavaFormatter();
        System.out.println(f.format(new File(args[0]), StandardCharsets.UTF_8));
    }
}
