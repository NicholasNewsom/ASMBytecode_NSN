import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class program5{
    public static void main(String[] args){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"DeclarePrintString", null, "java/lang/Object",null);
        
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
            mv.visitTypeInsn(Opcodes.NEW, "java/lang/String");
            mv.visitInsn(Opcodes.DUP);
            mv.visitLdcInsn("My name is Nick.");
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/String", "<init>", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            mv.visitVarInsn(Opcodes.ALOAD, 1); 
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
            return cw.toByteArray();

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
       
        }
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"DeclarePrintString.class");
        
        System.out.println("Done!");
    }
}    