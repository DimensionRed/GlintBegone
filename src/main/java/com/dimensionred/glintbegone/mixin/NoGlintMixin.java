package com.dimensionred.glintbegone.mixin;

import com.dimensionred.glintbegone.ItemWithNbt;
import com.dimensionred.glintbegone.GlintBegoneClient;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class NoGlintMixin {

	@Inject(method = "hasGlint", at = @At("HEAD"), cancellable = true)
	private void disableGlint(CallbackInfoReturnable<Boolean> cir) {
		ItemStack stack = (ItemStack) (Object) this;

		for (ItemWithNbt entry : GlintBegoneClient.CONFIG.disabledItems) {
			if (entry.matches(stack)) {
				cir.setReturnValue(false);
				return;
			}
		}
	}
}