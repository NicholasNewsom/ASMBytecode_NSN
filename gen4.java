//import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

import utils.Utilities;

public class gen4{
    public static void main(String[] args){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        
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
            mv.visitVarInsn(Opcodes.BIPUSH, 10);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitIntInsn(Opcodes.BIPUSH, 5);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "max", "(II)I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 5);
            

            
            mv.visitLdcInsn((Long)14L); 
            mv.visitVarInsn(Opcodes.LSTORE, 7);
            mv.visitLdcInsn((Long)12L);
            mv.visitVarInsn(Opcodes.LSTORE, 9);
            mv.visitVarInsn(Opcodes.LLOAD, 7);
            mv.visitVarInsn(Opcodes.LLOAD, 9);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Math", "max", "(II)I", false);
            mv.visitVarInsn(Opcodes.LSTORE, 11);



            mv.visitLdcInsn("147");
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 13);
            mv.visitLdcInsn("389");
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 15);
    
            Label label1 = new Label();
            mv.visitVarInsn(Opcodes.ILOAD, 13);
            mv.visitVarInsn(Opcodes.ILOAD, 15);
            mv.visitJumpInsn(Opcodes.IF_ICMPLT, label1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("147");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label label2 = new Label();
            mv.visitJumpInsn(Opcodes.GOTO, label2);
            mv.visitLabel(label1);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("389");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitLabel(label2);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
       
        }
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        Utilities.writeFile(b,"program4.class");
        
        System.out.println("Done!");
    }
}    