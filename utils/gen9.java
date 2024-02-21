import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class program9{
    public static void main(String[] args){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"Accumulator", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}  

        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            mv.visitInsn(Opcodes.DUP);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitInsn(Opcodes.ICONST_0);
            mv.visitVarInsn(Opcodes.ISTORE, 5);
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND,5, new Object[] {"java/util/Scanner", Opcodes.INTEGER, Opcodes.INTEGER}, 0, null);
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitInsn(Opcodes.ICONST_5);
            Label l1 = new Label();
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, l1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Type an integer for the stack.");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 7);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 7);
            mv.visitInsn(Opcodes.IADD);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitIincInsn(3, 1);
            mv.visitJumpInsn(Opcodes.GOTO, l0);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"Accumlator.class");
        
        System.out.println("Done!");
    }
}    