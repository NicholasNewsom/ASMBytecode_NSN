//import static utils.Utilities.writeFile;

import org.objectweb.asm.*;

import utils.Utilities;

public class gen1{
    public static void main(String[] args){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program1", null, "java/lang/Object",null);
        
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
            mv.visitLdcInsn(16);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitInsn(Opcodes.ICONST_5); 
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitInsn(Opcodes.IMUL);
            mv.visitVarInsn(Opcodes.ISTORE, 5);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
    
            mv.visitLdcInsn((Double)13.5);
            mv.visitVarInsn(Opcodes.DSTORE, 7);
            mv.visitLdcInsn((Double)8.35D);
            mv.visitVarInsn(Opcodes.DSTORE, 9);
            mv.visitVarInsn(Opcodes.DLOAD, 7);
            mv.visitVarInsn(Opcodes.DLOAD, 9);
            mv.visitInsn(Opcodes.DMUL);
            mv.visitVarInsn(Opcodes.DSTORE, 11);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 11);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
         
            mv.visitLdcInsn((float)10.0); 
            mv.visitVarInsn(Opcodes.FSTORE, 17); 
            mv.visitLdcInsn((float)4.0);
            mv.visitVarInsn(Opcodes.FSTORE, 18);
            mv.visitVarInsn(Opcodes.FLOAD, 17);
            mv.visitVarInsn(Opcodes.FLOAD, 18);
            mv.visitInsn(Opcodes.FMUL);
            mv.visitVarInsn(Opcodes.FSTORE, 19);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 19);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
    
            mv.visitLdcInsn((long)10l);
            mv.visitVarInsn(Opcodes.LSTORE, 19);
            mv.visitLdcInsn((Long)5l);
            mv.visitVarInsn(Opcodes.LSTORE, 21);
            mv.visitVarInsn(Opcodes.LLOAD, 19);
            mv.visitVarInsn(Opcodes.LLOAD, 21);
            mv.visitInsn(Opcodes.LMUL);
            mv.visitVarInsn(Opcodes.LSTORE, 23);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 23);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
           
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
       
        }
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        Utilities.writeFile(b,"program1.class");
        
        System.out.println("Done!");
    }
}    